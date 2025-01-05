package org.alexov.otus.audit.incoming;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/audit")
public class AuditController {

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserAudit(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok().build();
    }
}
