package app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Org;

public interface OrgRepository extends JpaRepository<Org, Long>{

}
