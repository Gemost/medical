package com.qst.medical.model;

import com.qst.medical.domain.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionModel extends Permission {
    private MetaModel meta;//存放meta封装的各个属性，icon、title等

    public MetaModel getMeta() {
        return meta;
    }

    public void setMeta(MetaModel meta) {
        this.meta = meta;
    }

}
