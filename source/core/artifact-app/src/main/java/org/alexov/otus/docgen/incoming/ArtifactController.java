package org.alexov.otus.docgen.incoming;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/artifact/{projectId}")
public class ArtifactController {

    @GetMapping("")
    public ResponseEntity<String> getArtifactByProjectId(@PathVariable Long projectId) {
        return ResponseEntity.ok().build();
    }
}
