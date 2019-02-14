package com.owncloud.android.datamodel;

import android.accounts.Account;

import com.owncloud.android.lib.resources.shares.OCShare;
import com.owncloud.android.lib.resources.shares.ShareType;
import com.owncloud.android.lib.resources.status.OCCapability;

import java.util.Collection;
import java.util.List;

import androidx.annotation.Nullable;

public interface FileDataStorageManagerInterface {

    OCFile getFileByPath(String path);

    Account getAccount();

    @Nullable
    OCFile getFileById(long id);

    void saveConflict(OCFile file, String etagInConflict);

    void deleteFileInMediaScan(String path);

    boolean saveFile(OCFile file);

    boolean fileExists(long id);

    List<OCFile> getFolderContent(OCFile f, boolean onlyOnDevice);

    void saveFolder(OCFile folder, Collection<OCFile> updatedFiles, Collection<OCFile> filesToRemove);

    boolean removeFile(OCFile file, boolean removeDBData, boolean removeLocalCopy);

    boolean removeFolder(OCFile folder, boolean removeDBData, boolean removeLocalContent);

    void moveLocalFile(OCFile file, String targetPath, String targetParentPath);

    boolean saveShare(OCShare share);

    List<OCShare> getSharesWithForAFile(String filePath, String accountName);

    void removeShare(OCShare share);

    void copyLocalFile(OCFile file, String targetPath);

    OCShare getFirstShareByPathAndType(String path, ShareType type, String shareWith);

    OCCapability saveCapabilities(OCCapability capability);

    void saveSharesDB(List<OCShare> shares);

    void removeSharesForFile(String remotePath);

    OCShare getShareById(long id);
}
