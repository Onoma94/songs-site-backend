package a.songs_site;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GuestBookRepository extends JpaRepository<GuestBook, Integer>, JpaSpecificationExecutor<GuestBook> {

}
