package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CollectionEntity {
    private int id;
    private String name;
    private String usu_cre;
    private Date fec_cre;
    private String usu_mod;
    private Date fec_mod;
}
