package abstraction.interfaces;

import java.io.Serializable;

// 1. Interfaces can extend(inherit) each other
// 2. 'Multiple inheritance' is ONLY allowed once both sides (parent&child) are interfaces
public interface Playable extends Loveable, Cloneable, Serializable {
    void play();
}
