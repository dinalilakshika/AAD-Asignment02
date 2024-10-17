package com.example.assignment02aad.service;

import com.example.assignment02aad.dto.custom.ItemStatus;
import com.example.assignment02aad.dto.custom.impl.ItemDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ItemService {
    void saveItem(ItemDto itemDto);
    ItemStatus getItemById(String itemCode);
    List<ItemDto> getAllItems();
    void updateItem(String itemCode, ItemDto itemDto);
    void deleteItem(String itemCode);
}
