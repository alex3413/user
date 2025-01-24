package org.alexov.otus.user.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.alexov.otus.common.model.ManifestData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

import static org.alexov.otus.user.model.ManifestFiel.MANIFEST;

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

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getInfo(@PathVariable("projectId") String projectId) {
        //TODO find manifest by id, return info with validation protocol
        return ResponseEntity.ok(ManifestData.builder()
                .projectId(projectId)
                .version("1.0.0")
                .fileId("2-manifest-arch-proj").build());
    }

    @PostMapping("/{projectId}")
    public ResponseEntity<?> createManifest(@PathVariable("projectId") String projectId, @RequestBody ManifestData manifest) {
        //TODO find manifest by id, return info with validation protocol
        return ResponseEntity.ok().build();
    }
    @PostMapping("/{projectId}/process")
    public ResponseEntity<?> processManifest(@PathVariable("projectId") String projectId, @RequestBody Object artifacts) {
        //TODO find manifest by id, return info with validation protocol
        return ResponseEntity.ok(MANIFEST);
    }


}
