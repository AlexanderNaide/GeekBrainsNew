package ru.gb.Bootcamp.Patterns.Iterator;

/**
 * Склад магазина
 */

public class MarketStore implements Collection{


    private String name;
    private String[] goods;
    GoodsIterator thisIterator;

    public MarketStore(String name, String[] goods) {
        this.name = name;
        this.goods = goods;
        thisIterator = new GoodsIterator();
    }

    public String getName() {
        return name;
    }

    @Override
    public MyIterator getMyIterator() {
        return thisIterator;
    }

    private class GoodsIterator implements MyIterator{

        int index;

        @Override
        public boolean hasNext() {
            if (index < goods.length){
                return true;
            } else {
                index = 0;
                return false;
            }
        }

        @Override
        public Object next() {
            return goods[index++];
        }

        @Override
        public int getIteratorPosition() {
            return index;
        }

        @Override
        public Object getItem() {
            return goods[index];
        }

        @Override
        public Object getIdItem(int id) {
            return goods[id];
        }

        @Override
        public boolean removeItem(int id) {
            if(id < goods.length){
                goods[id] = "------deleted------";
                return true;
            }
            return false;
        }
    }
}
