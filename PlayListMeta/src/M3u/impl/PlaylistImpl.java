/**
 */
package M3u.impl;

import M3u.M3uPackage;
import M3u.MediaFile;
import M3u.Playlist;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Playlist</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link M3u.impl.PlaylistImpl#getMediafile <em>Mediafile</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PlaylistImpl extends MinimalEObjectImpl.Container implements Playlist {
	/**
	 * The cached value of the '{@link #getMediafile() <em>Mediafile</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediafile()
	 * @generated
	 * @ordered
	 */
	protected EList<MediaFile> mediafile;

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
		return M3uPackage.Literals.PLAYLIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MediaFile> getMediafile() {
		if (mediafile == null) {
			mediafile = new EObjectResolvingEList<MediaFile>(MediaFile.class, this, M3uPackage.PLAYLIST__MEDIAFILE);
		}
		return mediafile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case M3uPackage.PLAYLIST__MEDIAFILE:
				return getMediafile();
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
			case M3uPackage.PLAYLIST__MEDIAFILE:
				getMediafile().clear();
				getMediafile().addAll((Collection<? extends MediaFile>)newValue);
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
			case M3uPackage.PLAYLIST__MEDIAFILE:
				getMediafile().clear();
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
			case M3uPackage.PLAYLIST__MEDIAFILE:
				return mediafile != null && !mediafile.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PlaylistImpl
