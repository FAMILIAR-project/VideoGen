/**
 */
package videogenPlaylist.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import videogenPlaylist.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VideogenPlaylistFactoryImpl extends EFactoryImpl implements VideogenPlaylistFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VideogenPlaylistFactory init() {
		try {
			VideogenPlaylistFactory theVideogenPlaylistFactory = (VideogenPlaylistFactory)EPackage.Registry.INSTANCE.getEFactory(VideogenPlaylistPackage.eNS_URI);
			if (theVideogenPlaylistFactory != null) {
				return theVideogenPlaylistFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VideogenPlaylistFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VideogenPlaylistFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case VideogenPlaylistPackage.PLAYLIST: return createPlaylist();
			case VideogenPlaylistPackage.MEDIA_FILE: return createMediaFile();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Playlist createPlaylist() {
		PlaylistImpl playlist = new PlaylistImpl();
		return playlist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediaFile createMediaFile() {
		MediaFileImpl mediaFile = new MediaFileImpl();
		return mediaFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VideogenPlaylistPackage getVideogenPlaylistPackage() {
		return (VideogenPlaylistPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VideogenPlaylistPackage getPackage() {
		return VideogenPlaylistPackage.eINSTANCE;
	}

} //VideogenPlaylistFactoryImpl
