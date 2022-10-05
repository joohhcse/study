package com.example.study.controller.api;

import com.example.study.controller.CrudController;
import com.example.study.ifs.CrudInterface;
import com.example.study.model.entity.Item;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.ItemApiRequest;
import com.example.study.model.network.response.ItemApiResponse;
import com.example.study.service.ItemApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/item")
//@RequiredArgsConstructor
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

//BaseService 장점 :
//UserApiController 처럼 상속을 받고
//@PostMapping, @RequestBody 등 반복적인 작업을 하지 않아도 됨
//CRUD가 있는 서비스 로직에만 신경쓰면 된다    

//2nd lesson
//    @Autowired
//    private ItemApiLogicService itemApiLogicService;
//
//    @PostConstruct
//    public void init() {
//        this.baseService = itemApiLogicService;
//    }

//1st lesson
//    @Override
//    @PostMapping("")    // /api/item
//    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
//        return itemApiLogicService.create(request);
//    }
//
//    @Override
//    @GetMapping("{id}") // /api/item/1 ... 1000
//    public Header<ItemApiResponse> read(@PathVariable Long id) {
//        return itemApiLogicService.read(id);
//    }
//
//    @Override
//    @PutMapping("")// /api/item
//    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
//        return itemApiLogicService.update(request);
//    }
//
//    @Override
//    @DeleteMapping("{id}")// /api/item/1 ... 1000
//    public Header delete(@PathVariable Long id) {
//        return itemApiLogicService.delete(id);
//    }

}
