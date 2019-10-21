package model;

import java.util.ArrayList;

public class ListReaders {
    private ArrayList<Reader> readers;
    private static ListReaders list;

    private ListReaders(){
        if(readers == null)
            readers = new ArrayList<>();
    }

    public static ListReaders getInstance(){
        if(list == null)
            list = new ListReaders();
        return list;
    }

    public void addReader(Reader reader){
        int index = readers.indexOf(reader);
        if(index == -1)
            readers.add(reader);
        else
            readers.set(index,reader);
    }

    public Reader getReader(Reader reader){
        if(reader == null || reader.getUsr().length() < 1)
            return null;
        int index = this.readers.indexOf(reader);
        if(index > -1) {
            Reader result = readers.get(index);
            if(reader.getPwd().equals(result.getPwd()))
                return result;
        }
        return null;
    }
}
