package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.User;
import guru.springframework.spring5webapp.domain.Document;
import guru.springframework.spring5webapp.domain.Department;
import guru.springframework.spring5webapp.repositories.UserRepository;
import guru.springframework.spring5webapp.repositories.DepartmentRepository;
import guru.springframework.spring5webapp.repositories.DocumentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final UserRepository userRepository;
    private final DocumentRepository documentRepository;
    private final DepartmentRepository departmentRepository;

    public BootStrapData(UserRepository userRepository, DocumentRepository documentRepository, DepartmentRepository departmentRepository){
        this.userRepository = userRepository;
        this.documentRepository = documentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Hernando","Garcia");
        Document book1 = new Document("Hazel & Gretel", "23983923892");
        Department department = new Department("Amazon", "Calle Nunez Ureta 662");
        department.setAddress("Wall Street road");
        department.setCity("London");
        department.setState("VI");
        departmentRepository.save(department);

        user1.getDocuments().add(book1);
        book1.getAuthors().add(user1);
        book1.setDepartment(department);
        department.getDocuments().add(book1);

        userRepository.save(user1);
        documentRepository.save(book1);
        departmentRepository.save(department);


        System.out.println("bootstrap");
        System.out.println("number of authors: "+ userRepository.count());
        System.out.println("number of publishers: "+ departmentRepository.count());
        System.out.println("Publisher Number of Books: " + department.getDocuments().size());

    }
}
