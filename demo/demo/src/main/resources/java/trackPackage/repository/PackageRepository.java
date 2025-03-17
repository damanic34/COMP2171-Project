package trackpackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trackpackage.model.Package;

public interface PackageRepository extends JpaRepository<Package, String> {
    // JpaRepository gives us basic CRUD operations automatically
}

