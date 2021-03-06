package org.jetbrains.cabal;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.haskell.icons.HaskellIcons;

import javax.swing.*;

public class CabalFileType extends LanguageFileType {
    public static final CabalFileType INSTANCE = new CabalFileType();
    @NonNls
    public static final String DEFAULT_EXTENSION = "cabal";

    private Icon myIcon;

    private CabalFileType() {
        super(CabalLanguage.INSTANCE);
        myIcon = HaskellIcons.CABAL;
    }

    @NotNull
    public String getName() {
        return "Cabal file";
    }

    @NotNull
    public String getDescription() {
        return "Cabal file";
    }

    @NotNull
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    public Icon getIcon() {
        return myIcon;
    }

    public String getCharset(@NotNull VirtualFile file, final byte[] content) {
        return "UTF-8";
    }
}