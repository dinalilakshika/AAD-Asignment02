package com.example.assignment02aad.service.impl;

import com.example.assignment02aad.customStatusCode.SelectedItemErrorStatus;
import com.example.assignment02aad.dao.ItemDao;
import com.example.assignment02aad.dto.custom.ItemStatus;
import com.example.assignment02aad.dto.custom.impl.ItemDto;
import com.example.assignment02aad.entity.impl.Item;
import com.example.assignment02aad.exception.DataPersistException;
import com.example.assignment02aad.exception.ItemNotFoundException;
import com.example.assignment02aad.service.ItemService;
import com.example.assignment02aad.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.assignment02aad.util.Mapping;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveItem(ItemDto dto) {
        dto.setItemCode(AppUtil.generateItemId());
        Item itemEntity = mapping.toItemEntity(dto);

        Item savedItem = itemDao.save(itemEntity);
        if (savedItem == null) {
            throw new DataPersistException("Item not saved");
        }
    }

    @Override
    public ItemStatus getItemById(String itemCode) {
        if (itemDao.existsById(itemCode)) {
            Item selectedItem = itemDao.getReferenceById(itemCode);
            return mapping.toItemDto(selectedItem);
        } else {
            return new SelectedItemErrorStatus(2, "Selected Item not found");
        }
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<Item> allItems = itemDao.findAll();
        return mapping.asItemDto(allItems);
    }

    @Override
    public void updateItem(String itemCode, ItemDto itemDto) {
        Optional<Item> byId = itemDao.findById(itemCode);
        if (!byId.isPresent()) {
            throw new ItemNotFoundException("Item not found");
        } else {
            Item itemToUpdate = byId.get();
            itemToUpdate.setDescription(itemDto.getDescription());
            itemToUpdate.setQty(Integer.parseInt(itemDto.getQty()));
            itemToUpdate.setPrice(Double.parseDouble(itemDto.getPrice()));

            itemDao.save(itemToUpdate);
        }
    }

    @Override
    public void deleteItem(String itemCode) {
        Optional<Item> foundItem = itemDao.findById(itemCode);
        if (!foundItem.isPresent()) {
            throw new ItemNotFoundException("Item not found");
        } else {
            itemDao.deleteById(itemCode);
        }
    }
}

