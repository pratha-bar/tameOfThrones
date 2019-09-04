package com.gt.facade;

import com.gt.model.Kingdom;
import com.gt.util.StringUtil;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created on 04/09/2019, 1:20 PM
 * KingdomFacade.java
 *
 * @author prathabarsaiyan
 */
public class KingdomFacade {

    /**
     * method to check if the ruler can rule the other kingdom with the message Provided
     * @param message
     * @param kingdomToWin
     * @param ruler
     * @return
     */
    public boolean isWon(String message, Kingdom kingdomToWin, Kingdom ruler){
        // if the kingdom to be ruled is already won
        if(kingdomToWin != null && kingdomToWin.isWon()){
            return kingdomToWin.getRuler().equals(ruler);
        }

        return messageContainsSymbolName(StringUtil.convertStringToCharCountMap(message), kingdomToWin.getSymbolCharCountMap());
    }

    /**
     * check whether message contains same or more number of same characters
     * @param messageMap map in which all values should be present
     * @param symbolMap map for which all values are considered to be present
     * @return
     */
    private boolean messageContainsSymbolName(Map<Character,Integer> messageMap, Map<Character,Integer> symbolMap){
        for(Entry<Character,Integer> entry: symbolMap.entrySet()){
            if(!messageMap.containsKey(entry.getKey()) || messageMap.get(entry.getKey()) < entry.getValue()){
                return false;
            }
        }
        return true;
    }

}
