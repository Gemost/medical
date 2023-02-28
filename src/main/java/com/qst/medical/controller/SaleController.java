package com.qst.medical.controller;

import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.Sale;
import com.qst.medical.service.SaleService;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@Api(tags = "药店信息控制器")
@RestController

@RequestMapping("/api/sales")
@CrossOrigin
public class SaleController {

    @Autowired
    private SaleService saleService;

    /**
     * 药店信息的分页查询,name不为空则模糊查询,当路径为""时，查询不分页
     * @param pn
     * @param size
     * @param name
     * @return
     */
    @GetMapping(value = {"/{pn}/{size}",""})
    public Msg getSaleWithPage(@PathVariable(value = "pn",required = false) Integer pn,
                               @PathVariable(value = "size",required = false) Integer size,
                               @RequestParam(required = false) String name) {
        PageInfo<Sale> info = saleService.getSaleWithPage(pn, size, name);
        if (info != null) {
            return Msg.success().data("salePageInfo",info);
        }
        return Msg.fail();
    }


    /**
     * 根据id查询一个药店
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Msg getSaleById(@PathVariable("id") Integer id) {
        Msg msg = saleService.getSaleById(id);
        return msg;
    }
    /**
     * 新增一个药店信息
     * @return
     */
    @RolesAllowed({"1"})
    @PostMapping(value = "")
    public Msg saveSale(@RequestBody Sale sale) {
        String name = sale.getSaleName();
        String phone = sale.getSalePhone();
        boolean leaf = (name == null || phone == null || name == "" || phone == "");
        if (leaf) {
            return Msg.fail().mess("填写信息不完整");
        }
        return saleService.saveSale(sale);
    }

    /**
     * 根据id删除药店
     * @param id
     * @return
     */
    @RolesAllowed({"1"})
    @DeleteMapping("{id}")
    public Msg deleteSaleById(@PathVariable("id") Integer id) {
        Msg msg = saleService.deleteSaleById(id);
        return msg;
    }


    /**
     * 根据id更新药店
     * @param sale
     * @return
     */
    @RolesAllowed({"1"})
    @PutMapping(value = "/{id}")
    public Msg updateSaleById(@PathVariable("id")Long id, @RequestBody Sale sale) {
        String name = sale.getSaleName();
        String phone = sale.getSalePhone();
        if (name == null || name == "") {
            return Msg.fail().mess("药店名称不能为空");
        }
        if (phone == null || phone == "") {
            return Msg.fail().mess("药店电话不能为空");
        }
        Msg msg = saleService.updateSaleById(id, sale);
        return msg;
    }
}