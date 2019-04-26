package com.company;

import java.util.ArrayList;

public class Journal  {

    private ArrayList<JournalEntry> listeners = new ArrayList<>();


    public void addComDataEnableEventListener(JournalEntry listener){
        listeners.add(listener);
    }
    //получение массива слушателей
    public JournalEntry[] getComDataEnableEventListeners(){
        return listeners.toArray(new JournalEntry[listeners.size()]);
    }

    private void StudentsCountChanged(JournalEntry journalEntry){
        AddJournalEntry(journalEntry);
    }
    private void StudentReferenceChanged(JournalEntry journalEntry){
        AddJournalEntry(journalEntry);
    }
    private void AddJournalEntry(JournalEntry journalEntry) {
        this.listeners.add(journalEntry);
    } //добавление элементов
    @Override
    public String toString() {
        return String.format(" Данные коллекции  = '%s'}",
                listeners);
    }

}
