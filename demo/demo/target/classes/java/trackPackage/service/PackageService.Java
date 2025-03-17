package trackpackage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trackpackage.model.Package;
import trackpackage.repository.PackageRepository;

import java.util.Optional;

@Service
public class PackageService {
    @Autowired
    private PackageRepository packageRepository;

    public Package addPackage(Package pkg) {
        return packageRepository.save(pkg);
    }

    public Optional<Package> getPackageByTrackingNumber(String trackingNumber) {
        return packageRepository.findById(trackingNumber);
    }

    public Package updatePackageStatus(String trackingNumber, String newStatus) {
        Optional<Package> optionalPackage = packageRepository.findById(trackingNumber);
        if (optionalPackage.isPresent()) {
            Package pkg = optionalPackage.get();
            pkg.setStatus(newStatus);
            return packageRepository.save(pkg);
        }
        throw new RuntimeException("Package not found!");
    }
}
