package untitled.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "logistics", path = "logistics")
public interface LogisticsRepository
    extends PagingAndSortingRepository<Logistics, String> {}
