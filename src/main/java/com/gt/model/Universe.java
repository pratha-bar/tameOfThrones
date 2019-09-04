package com.gt.model;

import com.gt.facade.KingdomFacade;
import com.gt.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 04/09/2019, 1:53 PM
 * Universe.java
 *
 * @author prathabarsaiyan
 */
public class Universe {
    private static final String NULL_VALUE = "None";
    public static final String NAME = "Southeros";

    static Map<String, Kingdom> nameToKingdomMapping = new HashMap <String, Kingdom>();

    private static final String KINGDOM_NAME_SPACE = "SPACE";
    private static final String KINGDOM_NAME_LAND = "LAND";
    private static final String KINGDOM_NAME_WATER = "WATER";
    private static final String KINGDOM_NAME_ICE = "ICE";
    private static final String KINGDOM_NAME_AIR = "AIR";
    private static final String KINGDOM_NAME_FIRE = "FIRE";

    private Kingdom ruler;
    private List<Kingdom> rulerAllies = new ArrayList <Kingdom>();
    private Kingdom spaceKingdom = createKingdom(KINGDOM_NAME_SPACE, "GORILLA","KING SHAN",true);
    private KingdomFacade kingdomFacade = new KingdomFacade();

    static {
        nameToKingdomMapping.put(KINGDOM_NAME_LAND,createKingdom(KINGDOM_NAME_LAND, "Panda"));
        nameToKingdomMapping.put(KINGDOM_NAME_WATER,createKingdom(KINGDOM_NAME_WATER, "Octopus"));
        nameToKingdomMapping.put(KINGDOM_NAME_ICE,createKingdom(KINGDOM_NAME_ICE,"Mammoth"));
        nameToKingdomMapping.put(KINGDOM_NAME_AIR,createKingdom(KINGDOM_NAME_AIR,"Owl"));
        nameToKingdomMapping.put(KINGDOM_NAME_FIRE,createKingdom(KINGDOM_NAME_FIRE, "Dragon"));
    }

    public String getRuler() {
        return ruler == null ? NULL_VALUE : ruler.getRulerName();
    }

    private static Kingdom createKingdom(String name, String symbol, String ruler, boolean isWon){
        Kingdom kingdom = new Kingdom();
        kingdom.setName(name);
        kingdom.setSymbolName(symbol);
        kingdom.setRulerName(ruler);
        kingdom.setWon(isWon);
        return kingdom;
    }

    private static Kingdom createKingdom(String name, String symbol){
        return createKingdom(name, symbol,null,false);
    }

    public String getRulerAllies() {
        return StringUtil.convertListToString(rulerAllies, NULL_VALUE);
    }

    public void decodeSecretMessage(String msg){
        if(StringUtil.isEmpty(msg) || !msg.contains(",")) {
            return;
        }
        String kingdomName = msg.substring(0, msg.indexOf(",")).toUpperCase();
        Kingdom kingdom = nameToKingdomMapping.get(kingdomName);
        if(kingdom == null){
            return;
        }

        msg = msg.substring(kingdomName.length());
        boolean isWon = kingdomFacade.isWon(msg,kingdom, spaceKingdom);
        if(isWon) {
            kingdom.setWon(isWon);
            kingdom.setRuler(spaceKingdom);
            kingdom.setRulerName(spaceKingdom.getRulerName());
            rulerAllies.add(kingdom);

            if(rulerAllies.size() > 2){
                ruler = spaceKingdom;
            }
        }
    }


}
