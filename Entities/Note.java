package Entities;

import lombok.Data;

@Data
public class Note {
    int noteVal;
    NoteType noteType;

    public Note(int noteVal, NoteType noteType) {
        this.noteVal = noteVal;
        this.noteType = noteType;
    }
}
