package com.greglturnquist.learningspringboot.learningspringboot;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Controller
public class HomeController {

    private static final String BASE_PATH = "/images";
    private static final String FILENAME = "{fileName:.+}";

    private final ImageService imageService;

    public HomeController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping(value = BASE_PATH + "/" + FILENAME + "/raw", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public Mono<ResponseEntity<?>> oneRawImage(final @PathVariable String fileName) {
        return imageService.findOneImage(fileName).map(
                resource -> {
                    try {
                        return ResponseEntity
                                .ok()
                                .contentLength(resource.contentLength())
                                .body(new InputStreamResource(resource.getInputStream()));
                    } catch (IOException e) {
                        return ResponseEntity
                                .badRequest()
                                .body("Couldn't find " + fileName + " => " + e.getMessage());
                    }
                }
        );
    }

    @PostMapping(BASE_PATH)
    public Mono<String> createFile(final @RequestPart(name = "file") Flux<FilePart> files) {
        return imageService.createImage(files).then(Mono.just("redirect:/"));
    }

    @DeleteMapping(BASE_PATH + "/" + FILENAME)
    public Mono<String> deleteFile(final @PathVariable String fileName) {
        return imageService.deleteImage(fileName).then(Mono.just("redirect:/"));
    }

    @GetMapping("/")
    public Mono<String> index(final Model model) {
        model.addAttribute("images", imageService.findAllImages());
        return Mono.just("index");
    }
}
