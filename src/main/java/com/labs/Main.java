package com.labs;

import com.labs.enums.Genre;
import com.labs.enums.Language;
import com.labs.io.JSONLibrary;
import com.labs.io.TXTLibrary;
import com.labs.io.XMLLibrary;
import com.labs.model.Library;
import com.labs.model.TextBook;
import com.labs.model.Vocabulary;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.getBooks().add(
            new Vocabulary.VocabularyBuilder()
                    .setName("THE WASTE LAND")
                    .setAuthor("T.S. ELIOT")
                    .setPublication("Ritual to Romance")
                    .setYearOfPublication(1920)
                    .setLanguageFrom(Language.RUSSIAN)
                    .setLanguageTo(Language.UKRAINIAN)
                    .build()
        );
        library.getBooks().add(
            new Vocabulary.VocabularyBuilder()
                    .setName("Marra")
                    .setAuthor("A. S. Macro")
                    .setPublication("UTVH")
                    .setYearOfPublication(1994)
                    .setLanguageFrom(Language.RUSSIAN)
                    .setLanguageTo(Language.GERMAN)
                    .build()
        );
        library.getBooks().add(
                new Vocabulary.VocabularyBuilder()
                        .setYearOfPublication(2020)
                        .setLanguageFrom(Language.UKRAINIAN)
                        .setLanguageTo(Language.ENGLISH)
                        .setName("Carob")
                        .setAuthor("P. A. Olet")
                        .setPublication("Port")
                        .build()
        );
        library.getBooks().add(
            new TextBook.TextBookBuilder()
                    .setAuthor("Шевченко")
                    .setName("Кобзар")
                    .setPublication("ТОУК")
                    .setYearOfPublication(1840)
                    .setGenre(Genre.NOWELL)
                    .build()
        );
        library.getBooks().add(
                new TextBook.TextBookBuilder()
                        .setName("Tower of the fools")
                        .setAuthor("Andrzej Sapkowski")
                        .setPublication("Wither")
                        .setYearOfPublication(2020)
                        .setGenre(Genre.FANTASY)
                        .build()
        );
        library.getBooks().add(
                new TextBook.TextBookBuilder()
                        .setName("Lord of the rings")
                        .setAuthor("J. R. R. Tolkien")
                        .setPublication("Allen & Unwin")
                        .setYearOfPublication(1954)
                        .setGenre(Genre.FANTASY)
                        .build()
        );

        try {
            new JSONLibrary().serialize(library, "library.json");
            new XMLLibrary().serialize(library, "library.xml");
            new TXTLibrary().serialize(library, "library.txt");



            Library libraryFromJSON = new JSONLibrary().deserialize("library.json");
            Library libraryFromXML = new XMLLibrary().deserialize("library.xml");

            System.out.println("\nlib from JSON:\n" + libraryFromJSON);
            System.out.println("\nlib from XML:\n" + libraryFromXML);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}
