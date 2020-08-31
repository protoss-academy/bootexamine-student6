package com.protosstechnology.train.bootexamine.controller;

import com.protosstechnology.train.bootexamine.Entity.Document;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@Slf4j
@RequestMapping("/document")
public class DocumentController {

    public ArrayList<Document> documentArrayList = new ArrayList<>();
    @GetMapping("/{id}")
    @Operation(summary = "Get Document by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Found the User",
                    content = { @Content(mediaType = "application/json",
                            schema =   @Schema(implementation =  Document.class))}),
            @ApiResponse(responseCode = "400",description = "Invalid id document",
                    content = @Content),
            @ApiResponse(responseCode = "400",description = "Document not found",
                    content = @Content)
    })
    public ResponseEntity<Document> getDocument(@PathVariable("id") int id){
        return ResponseEntity.ok().body(documentArrayList.get(id));
    }

    @PutMapping("/{id}")
    @RequestBody
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "default response",
                    content = { @Content(mediaType = "*/*",
                            schema =   @Schema(implementation =  Document.class))})
    })
    public ResponseEntity<Document> putDocument(@RequestBody Long id,
                                                   @RequestBody String documentNumber,
                                                   @RequestBody String description){
        Document document = new Document();
        document.setId(id);
        document.setDescription(description);
        document.setDocumentNumber(documentNumber);
        documentArrayList.add(document);
        return ResponseEntity.ok().body(document);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "default response",
                    content = { @Content(mediaType = "*/*",
                            schema =   @Schema(implementation =  String.class))})
    })
    public ResponseEntity<Document> deleteDocument(@PathVariable("id") int id){
        documentArrayList.remove(id);
        return ResponseEntity.ok().body(documentArrayList.get(0));
    }

    @PostMapping()
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "default response",
                    content = { @Content(mediaType = "*/*",
                            schema =   @Schema(implementation =  Document.class))})
    })
    public ResponseEntity<Document> postDocument(@RequestBody Long id,
                                                    @RequestBody String documentNumber,
                                                    @RequestBody String description){
        Document document = new Document();
        document.setId(id);
        document.setDescription(description);
        document.setDocumentNumber(documentNumber);
        documentArrayList.add(document);
        return ResponseEntity.ok().body(document);
    }
}
