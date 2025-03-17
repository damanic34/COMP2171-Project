package trackpackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trackpackage.model.Package;
import trackpackage.service.PackageService;

import java.util.Optional;

@RestController
@RequestMapping("/packages")
@CrossOrigin(origins = "*") // Allows frontend to communicate with backend
public class PackageController {

    @Autowired
    private PackageService packageService;

    @PostMapping("/add")
    public Package addPackage(@RequestBody Package pkg) {
        return packageService.addPackage(pkg);
    }

    @GetMapping("/{trackingNumber}")
    public Optional<Package> getPackage(@PathVariable String trackingNumber) {
        return packageService.getPackageByTrackingNumber(trackingNumber);
    }

    @PutMapping("/{trackingNumber}/status")
    public Package updatePackageStatus(@PathVariable String trackingNumber, @RequestParam String status) {
        return packageService.updatePackageStatus(trackingNumber, status);
    }

}

