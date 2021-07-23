package guru.springframework.spring5webapp.bootstrap;


import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapRunner implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRespository bookRespository;

    public BootStrapRunner(AuthorRepository authorRepository, BookRespository bookRespository) {
        this.authorRepository = authorRepository;
        this.bookRespository = bookRespository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric" , "Evans" );
        Book ddd = new Book( "Loshens real java programmer" ,  "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRespository.save(ddd);

        Author losh = new Author("Losh" , "Naicker" );
        Book pro = new Book( "pro ded java programmer" ,  "123124");
        losh.getBooks().add(ddd);
        pro.getAuthors().add(eric);
        authorRepository.save(losh);
        bookRespository.save(pro);


        Author mel = new Author("Mel" , "Naicker" );
        Book fire = new Book( "pro fire safety" ,  "123125");
        mel.getBooks().add(fire);
        fire.getAuthors().add(mel);
        authorRepository.save(losh);
        bookRespository.save(fire);

        Book fire2 = new Book( "pro fire safety the sequel" ,  "123126");
        mel.getBooks().add(fire2);
        bookRespository.save(fire2);

        System.out.println("Books  " + bookRespository.count());
        System.out.println("End of Bootstrap " + authorRepository.toString());

    }


}
