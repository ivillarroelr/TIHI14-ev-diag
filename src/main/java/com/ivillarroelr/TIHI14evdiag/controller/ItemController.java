package com.ivillarroelr.TIHI14evdiag.controller;

import com.ivillarroelr.TIHI14evdiag.dto.ItemDTO;
import com.ivillarroelr.TIHI14evdiag.dto.MetadataDTO;
import com.ivillarroelr.TIHI14evdiag.dto.ResponseObjectDTO;
import com.ivillarroelr.TIHI14evdiag.model.Item;
import com.ivillarroelr.TIHI14evdiag.service.ICategoryService;
import com.ivillarroelr.TIHI14evdiag.service.ICountryService;
import com.ivillarroelr.TIHI14evdiag.service.ICurrencyService;
import com.ivillarroelr.TIHI14evdiag.service.IItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
    private IItemService service;

    @Autowired
    private ICategoryService catService;

    @Autowired
    private ICountryService coService;

    @Autowired
    private ICurrencyService cuService;

    Logger logger = LoggerFactory.getLogger(ItemController.class);

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseObjectDTO> findItem(@PathVariable Integer id) {
        ResponseObjectDTO response = new ResponseObjectDTO();
        MetadataDTO metadata = new MetadataDTO();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);
        try{
            Item item = service.readById(id);
            if(item.getItem_id()>0) {
                logger.info("ITEM ENCONTRADO ID: "+id);
                response.setData(item);
                metadata.setStatusCode(0);
                metadata.setMessage("ID: "+id+" encontrada en la base de datos");
                metadata.setTimestamp(formatDateTime);
                response.setMetadata(metadata);
                return new ResponseEntity<ResponseObjectDTO>(response, HttpStatus.OK);

            } else {
                logger.info("ITEM NO ENCONTRADO ID: "+id);
                response.setData(null);
                metadata.setMessage("ID no encontrada en la base de datos");
                metadata.setStatusCode(20);
                metadata.setTimestamp(formatDateTime);
                response.setMetadata(metadata);
                return new ResponseEntity<ResponseObjectDTO>(response, HttpStatus.NOT_FOUND);
            }
        } catch(Exception e) {
            logger.error("ERROR: "+e.getMessage());
            metadata.setTimestamp(formatDateTime);
            metadata.setMessage("Ha ocurrido un error inesperado: "+e.getMessage());
            metadata.setStatusCode(21);
            response.setMetadata(metadata);
            return new ResponseEntity<ResponseObjectDTO>(response, HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<ResponseObjectDTO> createItem(@RequestBody ItemDTO itemDTO){
        ResponseObjectDTO response = new ResponseObjectDTO();
        Item item = new Item();
        MetadataDTO metadata = new MetadataDTO();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);
        try{
            item.setCategory_id(catService.readById(itemDTO.getCategory_id()));
            item.setCountry_id(coService.readByShortname(itemDTO.getCountry()));
            item.setCurrency_id(cuService.readByShortname(itemDTO.getCurrency()));
            item.setPrice(itemDTO.getPrice());
            item.setTitle(itemDTO.getTitle());
            item.setSymbol(cuService.getSymbolByShortname(itemDTO.getCurrency()));
            Item itemResponse = service.save(item);
            metadata.setStatusCode(1);
            metadata.setTimestamp(formatDateTime);
            metadata.setMessage("ITEM creado exitosamente. ID: "+itemResponse.getItem_id());
            response.setMetadata(metadata);
            response.setData(itemResponse);
            logger.info("ITEM CREADO ID: "+itemResponse.getItem_id());
            return new ResponseEntity<ResponseObjectDTO>(response, HttpStatus.OK);

        } catch(Exception e){
            logger.error("ERROR: "+e.getMessage());
            metadata.setTimestamp(formatDateTime);
            metadata.setMessage("Ha ocurrido un error inesperado: "+e.getMessage());
            metadata.setStatusCode(21);
            response.setMetadata(metadata);
            return new ResponseEntity<ResponseObjectDTO>(response, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObjectDTO> deleteCourse(@PathVariable() Integer id) {
        ResponseObjectDTO response = new ResponseObjectDTO();
        MetadataDTO metadata = new MetadataDTO();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);
        try{
            Item item = service.readById(id);
            if(item.getItem_id()>0) {
                service.delete(id);
                logger.info("ITEM ELIMINADO ID: "+id);
                metadata.setTimestamp(formatDateTime);
                metadata.setMessage("Item eliminado exitosamente");
                metadata.setStatusCode(0);
                response.setMetadata(metadata);
                return new ResponseEntity<ResponseObjectDTO>(response, HttpStatus.OK);
            } else {
                logger.info("ITEM NO ENCONTRADO ID: "+id);
                metadata.setTimestamp(formatDateTime);
                metadata.setMessage("ID no encontrada en la base de datos");
                metadata.setStatusCode(20);
                response.setMetadata(metadata);
                return new ResponseEntity<ResponseObjectDTO>(response, HttpStatus.OK);
            }
        } catch(Exception e) {
            logger.error("ERROR: "+e.getMessage());
            metadata.setTimestamp(formatDateTime);
            metadata.setMessage("Ha ocurrido un error inesperado: "+e.getMessage());
            metadata.setStatusCode(21);
            response.setMetadata(metadata);
            return new ResponseEntity<ResponseObjectDTO>(response, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObjectDTO> modifyItem(@PathVariable() Integer id,
                                                 @RequestBody ItemDTO itemDTO) {
        ResponseObjectDTO response = new ResponseObjectDTO();
        MetadataDTO metadata = new MetadataDTO();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);
        try {
            Item item = service.readById(id);
            if (item.getItem_id() > 0) {
                item.setCategory_id(catService.readById(id));
                item.setCountry_id(coService.readByShortname(itemDTO.getCountry()));
                item.setCurrency_id(cuService.readByShortname(itemDTO.getCurrency()));
                item.setPrice(itemDTO.getPrice());
                item.setTitle(itemDTO.getTitle());
                item.setSymbol(cuService.getSymbolByShortname(itemDTO.getCurrency()));
                Item itemResponse = service.modify(item);
                metadata.setStatusCode(1);
                metadata.setTimestamp(formatDateTime);
                logger.info("ITEM EDITADO ID: "+itemResponse.getItem_id());
                metadata.setMessage("ITEM editado exitosamente. ID: " + itemResponse.getItem_id());
                response.setMetadata(metadata);
                response.setData(itemResponse);
                return new ResponseEntity<ResponseObjectDTO>(response, HttpStatus.OK);
            } else {
                logger.info("ITEM NO ENCONTRADO ID: "+id);
                metadata.setTimestamp(formatDateTime);
                metadata.setMessage("ID no encontrada en la base de datos");
                metadata.setStatusCode(20);
                response.setMetadata(metadata);
                return new ResponseEntity<ResponseObjectDTO>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            logger.error("ERROR: "+e.getMessage());
            metadata.setTimestamp(formatDateTime);
            metadata.setMessage("Ha ocurrido un error inesperado: " + e.getMessage());
            metadata.setStatusCode(21);
            response.setMetadata(metadata);
            return new ResponseEntity<ResponseObjectDTO>(response, HttpStatus.OK);
        }
    }
}
