/**
 */
package M3UPlaylist.impl;

import M3UPlaylist.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class M3UPlaylistFactoryImpl extends EFactoryImpl implements M3UPlaylistFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static M3UPlaylistFactory init() {
		try {
			M3UPlaylistFactory theM3UPlaylistFactory = (M3UPlaylistFactory)EPackage.Registry.INSTANCE.getEFactory(M3UPlaylistPackage.eNS_URI);
			if (theM3UPlaylistFactory != null) {
				return theM3UPlaylistFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new M3UPlaylistFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M3UPlaylistFactoryImpl() {
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
			case M3UPlaylistPackage.PLAYLIST: return createPlaylist();
			case M3UPlaylistPackage.ENTRY: return createEntry();
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
	public Entry createEntry() {
		EntryImpl entry = new EntryImpl();
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M3UPlaylistPackage getM3UPlaylistPackage() {
		return (M3UPlaylistPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static M3UPlaylistPackage getPackage() {
		return M3UPlaylistPackage.eINSTANCE;
	}

} //M3UPlaylistFactoryImpl
