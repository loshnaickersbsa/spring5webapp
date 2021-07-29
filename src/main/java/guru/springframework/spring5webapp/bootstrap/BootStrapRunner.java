package guru.springframework.spring5webapp.bootstrap;


import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRespository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapRunner implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRespository bookRespository;
    private final PublisherRepository publisherRepository;

    public BootStrapRunner(AuthorRepository authorRepository, BookRespository bookRespository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRespository = bookRespository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher amazon = new Publisher("Amazon", "Silicone valley", "SiliconeValley", "California","2191" );
        publisherRepository.save(amazon);

        Author eric = new Author("Eric" , "Evans" );
        Book ddd = new Book( "Loshens real java programmer" ,  "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);

        ddd.setPublisher(amazon);
        amazon.getBooks().add(ddd);
        bookRespository.save(ddd);
        publisherRepository.save(amazon);


        Author losh = new Author("Losh" , "Naicker" );
        Book pro = new Book( "pro ded java programmer" ,  "123124");
        losh.getBooks().add(ddd);
        pro.getAuthors().add(eric);
        authorRepository.save(losh);
        bookRespository.save(pro);

        pro.setPublisher(amazon);
        amazon.getBooks().add(pro);
        bookRespository.save(pro);
        publisherRepository.save(amazon);




        Author mel = new Author("Mel" , "Naicker" );
        Book fire = new Book( "pro fire safety" ,  "123125");
        mel.getBooks().add(fire);
        fire.getAuthors().add(mel);
        authorRepository.save(mel);
        bookRespository.save(fire);

        Book fire2 = new Book( "pro fire safety the sequel" ,  "123126");
        mel.getBooks().add(fire2);
        bookRespository.save(fire2);

        fire.setPublisher(amazon);
        amazon.getBooks().add(fire);
        fire2.setPublisher(amazon);
        amazon.getBooks().add(fire2);
        publisherRepository.save(amazon);
        bookRespository.save(fire);
        bookRespository.save(fire2);

        System.out.println("Books  " + bookRespository.count());
        System.out.println("Authors " + authorRepository.count());
        System.out.println("Publisher rep " + publisherRepository.count());

        System.out.println(" all " + amazon.getBooks().size());
        System.out.println(" all " + publisherRepository.findAll());

        for ( Publisher publisher: publisherRepository.findAll()
             ) {
            System.out.println("name: " + publisher.getName() + " id:  " + publisher.getId() );
            for ( Book book :publisher.getBooks()) {
                System.out.println("book -> " + book.getTitle());
            }
            System.out.println("size"  );

        }

    }


}
