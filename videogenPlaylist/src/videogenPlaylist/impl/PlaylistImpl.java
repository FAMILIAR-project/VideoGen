/**
 */
package videogenPlaylist.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import videogenPlaylist.MediaFile;
import videogenPlaylist.Playlist;
import videogenPlaylist.VideogenPlaylistPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Playlist</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link videogenPlaylist.impl.PlaylistImpl#getMediaFile <em>Media File</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PlaylistImpl extends MinimalEObjectImpl.Container implements Playlist {
	/**
	 * The cached value of the '{@link #getMediaFile() <em>Media File</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediaFile()
	 * @generated
	 * @ordered
	 */
	protected EList<MediaFile> mediaFile;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlaylistImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VideogenPlaylistPackage.Literals.PLAYLIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MediaFile> getMediaFile() {
		if (mediaFile == null) {
			mediaFile = new EObjectResolvingEList<MediaFile>(MediaFile.class, this, VideogenPlaylistPackage.PLAYLIST__MEDIA_FILE);
		}
		return mediaFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VideogenPlaylistPackage.PLAYLIST__MEDIA_FILE:
				return getMediaFile();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VideogenPlaylistPackage.PLAYLIST__MEDIA_FILE:
				getMediaFile().clear();
				getMediaFile().addAll((Collection<? extends MediaFile>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VideogenPlaylistPackage.PLAYLIST__MEDIA_FILE:
				getMediaFile().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VideogenPlaylistPackage.PLAYLIST__MEDIA_FILE:
				return mediaFile != null && !mediaFile.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PlaylistImpl
