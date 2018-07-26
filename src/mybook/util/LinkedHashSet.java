package mybook.util;

public class LinkedHashSet implements IHashSet {

    private int tamanho;
    private final double FATOR_DE_CARGA = 0.75;
    private Entry[] entries = new Entry[31];

    @Override
    public void put(Object data) {

        int i = hash(data);

        if (entries[i] != null) {
            Entry temp = entries[i];
            while (temp.getProxima() != null) {
                temp = temp.getProxima();
            }
            temp.setProxima(new Entry(data));
            tamanho++;
        } else {
            entries[i] = new Entry(data);
            tamanho++;
        }

        if (loadFactor() > FATOR_DE_CARGA) {
            resize();
        }
    }

    @Override
    public boolean contains(Object data) {

        int i = hash(data);

        if (entries[i] != null) {
            Entry temp = entries[i];
            if (temp.getKey().equals(data)) {
                return true;
            }
            while (temp.getProxima() != null) {
                if (temp.getKey().equals(data)) {
                    return true;
                }
                temp = temp.getProxima();
            }

            return false;
        }
        return false;
    }

    @Override
    public void remove(Object data) {

        int i = hash(data);
        if (entries[i] != null) {

            Entry temp = entries[i];

            if (temp.getKey().equals(data) && temp.getProxima() == null) {
                entries[i] = null;
                tamanho--;
                return;
            }

            while (temp.getProxima() != null) {

                if (temp.getKey().equals(data)) {
                    entries[i].setProxima(temp.getProxima());
                    tamanho--;
                    return;
                }
                temp = temp.getProxima();
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }

    @Override
    public int size() {
        return tamanho;
    }

    private int hash(Object key) {
        return Math.abs(key.hashCode()) % entries.length;
    }

    private double loadFactor() {
        return size() / (double) entries.length;
    }

    private void resize() {
        Entry[] temp = entries;
        entries = new Entry[entries.length * 2];
        for (Entry e : temp) {
            while (e != null) {
                put(e.getKey());
                e = e.getProxima();
            }
        }
    }

    public class Entry {

        private Object key;
        private Entry proxima;

        public Entry(Object key) {
            this.key = key;
            proxima = null;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public void setProxima(Entry proxima) {
            this.proxima = proxima;
        }

        public Entry getProxima() {
            return proxima;
        }
    }

    //teste da classe
//    public static void main(String[] args) {
//
//        LinkedHashSet hash = new LinkedHashSet();
//
//        if (hash.size() == 0) {
//            System.out.println("Hash vazia");
//        }
//
//        hash.put(1);
//        hash.put(2);
//        hash.put(3);
//        hash.put(1);
//        hash.put("abacaxi");
//        hash.put("batata");
//        hash.put("cenoura");
//        hash.put("abacaxi");
//
//        if (hash.size() == 8) {
//            System.out.println("Tamanho da hash - 8");
//        }
//
//        if (hash.contains(1)) {
//            System.out.println("Contém 1");
//        }
//
//        if (hash.contains(2)) {
//            System.out.println("Contém 2");
//        }
//
//        if (hash.contains("abacaxi")) {
//            System.out.println("Contém abacaxi");
//        }
//
//        hash.remove(3);
//        System.out.println("Removendo 3");
//
//        hash.remove("cenoura");
//        System.out.println("Removendo cenoura");
//
//        if (hash.size() == 6) {
//            System.out.println("Tamanho da hash - 6");
//        }
//
//        if (!hash.contains(3)) {
//            System.out.println("Não contém 3");
//        }
//
//        if (!hash.contains("cenoura")) {
//            System.out.println("Não contém cenoura");
//        }
//    }

}
