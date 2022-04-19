import java.util.Arrays;
import java.util.Objects;

public class BookService {

    public Book[] filterBooksByAuthor(Author author, Book[] books) {

            if(author==null||books==null){

                return new Book[0];
            }
        int matchbookAmount=0;
            for(Book book:books) {

                if (book.hasAuthor(author)) {

                    matchbookAmount++;
                }

            }

        Book[] FilterBooks=new Book[matchbookAmount];
            int index=0;

            for(Book book:books){

                if(book.hasAuthor(author)){

                    FilterBooks[index++]=book;
                }
            }

            return  FilterBooks;

    }

// Method Tow

    public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {


        if(publisher==null||books==null){
            return new Book[0];
        }

        int MatchBookAmount=0;

        for(Book book:books){

            if(book.getPublisher().equals(publisher)) {
                MatchBookAmount++;
            }
        }

        Book[] FilterBooks=new Book[MatchBookAmount];
        int index=0;

        for(Book book:books){

            if(book.getPublisher().equals(publisher)){

                FilterBooks[index++]=book;
            }
        }

        return  FilterBooks;
    }

// Method Three

    public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {

        if(books ==null ){ return new Book[0];  }

        int MatchBookAmount=0;

        for(Book book:books){

            if(book.getPublishingYear()>=yearFromInclusively){

                MatchBookAmount++;

            }}
            Book[] FilterBooks=new Book[MatchBookAmount];

        int index=0;
            for(Book book:books){

                if(book.getPublishingYear()>=yearFromInclusively){

                    FilterBooks[index++]=book;

                }

            }
        return  FilterBooks;


    }



}
