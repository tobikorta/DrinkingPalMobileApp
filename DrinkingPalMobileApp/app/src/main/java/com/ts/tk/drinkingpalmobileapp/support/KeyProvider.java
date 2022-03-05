package com.ts.tk.drinkingpalmobileapp.support;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemKeyProvider;

public abstract class KeyProvider extends ItemKeyProvider<String> {

    /**
     * Creates a new provider with the given scope.
     *
     * @param scope Scope can't be changed at runtime.
     */
    protected KeyProvider(int scope) {
        super(scope);
    }


}
