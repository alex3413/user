package org.alexov.otus.manifest.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@Tag(name = "Операции манифеста")
@RequestMapping("/manifest")
public class ManifestController {

    @PostMapping("/download")
    public ResponseEntity<?> downloadManifest(@RequestPart MultipartFile manifest, @RequestParam Long projectId) {
        //TODO Download manifest to minio
        var uuid = UUID.randomUUID().toString();
        return ResponseEntity.ok(uuid);
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<?> getInfo(@PathVariable String id) {
        //TODO find manifest by id, return info with validation protocol
        return ResponseEntity.ok().build();
    }
}
