package com.gt.model;

import com.gt.util.StringUtil;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created on 04/09/2019, 1:18 PM
 * Kingdom.java
 *
 * @author prathabarsaiyan
 */
@Getter
@Setter
@NoArgsConstructor
public class Kingdom {
    String name;
    String symbolName;
    boolean won;
    Kingdom ruler;
    String rulerName;
    Map<Character,Integer> symbolCharCountMap;


    public Kingdom(String name, String symbolName) {
        this.name = name;
        this.symbolName = symbolName;
        this.won = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Kingdom)) {
            return false;
        }

        Kingdom kingdom = (Kingdom) o;

        return this.getName() != null ? this.getName().equals(kingdom.getName()) : kingdom.getName() == null;
    }

    @Override
    public int hashCode() {
        return this.getName() != null ? this.getName().hashCode() : 0;
    }

    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
        intializeSymbolCountMap(symbolName);
    }

    private void intializeSymbolCountMap(String symbolName) {
        symbolCharCountMap = StringUtil.convertStringToCharCountMap(symbolName);
    }

    @Override
    public String toString() {
        return name;
    }
}
