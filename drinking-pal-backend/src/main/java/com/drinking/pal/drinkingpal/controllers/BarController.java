package com.drinking.pal.drinkingpal.controllers;

import com.drinking.pal.drinkingpal.entities.Bar;
import com.drinking.pal.drinkingpal.service.BarService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/bars")
public class BarController {

    private final BarService barService;
    private final Path rootLocation;

    public BarController(BarService barService) {
        this.barService = barService;
        this.rootLocation = Paths.get("bar-images");
    }

    @GetMapping
    public ResponseEntity<List<Bar>> getAllBars() {
        return new ResponseEntity<>(barService.getAllBars(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bar> getBarById(@PathVariable("id") Long barId) {
        return new ResponseEntity<>(barService.getById(barId), HttpStatus.OK);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<Resource> getBarImage(@PathVariable("id") Long id) {
        String fileName = id + ".jpeg";
        Resource file = loadAsResource(fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    private Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new RuntimeException(
                        "Could not read file: " + filename);

            }
        }
        catch (MalformedURLException e) {
            throw new RuntimeException("Could not read file: " + filename, e);
        }
    }
}
