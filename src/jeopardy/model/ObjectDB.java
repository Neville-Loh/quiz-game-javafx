package jeopardy.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ObjectDB implements Serializable {

	private static final long serialVersionUID = 1L;
    private Map<String, Boolean> _isAttempted;
    private int _winning;
    
    
    
    public ObjectDB() {
    	_winning = 0;
    	_isAttempted = new HashMap<String, Boolean>();
    }

    public int getWinning() {
        return _winning;
    }

    public void setWinning(int winning) {
    	_winning = winning;
    }

    public Map<String, Boolean> getIsAttemptedMap() {
        return _isAttempted;
    }

    public void setIsAttemptedMap(Map<String, Boolean> map) {
    	_isAttempted = map;
    }
}