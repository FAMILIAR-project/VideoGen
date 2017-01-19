/**
 */
package videogenPlaylist;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see videogenPlaylist.VideogenPlaylistFactory
 * @model kind="package"
 * @generated
 */
public interface VideogenPlaylistPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "videogenPlaylist";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/videogenPlaylist";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "videogenPlaylist";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VideogenPlaylistPackage eINSTANCE = videogenPlaylist.impl.VideogenPlaylistPackageImpl.init();

	/**
	 * The meta object id for the '{@link videogenPlaylist.impl.PlaylistImpl <em>Playlist</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see videogenPlaylist.impl.PlaylistImpl
	 * @see videogenPlaylist.impl.VideogenPlaylistPackageImpl#getPlaylist()
	 * @generated
	 */
	int PLAYLIST = 0;

	/**
	 * The feature id for the '<em><b>Media File</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYLIST__MEDIA_FILE = 0;

	/**
	 * The number of structural features of the '<em>Playlist</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYLIST_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Playlist</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYLIST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link videogenPlaylist.impl.MediaFileImpl <em>Media File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see videogenPlaylist.impl.MediaFileImpl
	 * @see videogenPlaylist.impl.VideogenPlaylistPackageImpl#getMediaFile()
	 * @generated
	 */
	int MEDIA_FILE = 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_FILE__PATH = 0;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_FILE__DURATION = 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_FILE__TEXT = 2;

	/**
	 * The feature id for the '<em><b>XAxis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_FILE__XAXIS = 3;

	/**
	 * The feature id for the '<em><b>YAxis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_FILE__YAXIS = 4;

	/**
	 * The number of structural features of the '<em>Media File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_FILE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Media File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_FILE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link videogenPlaylist.Playlist <em>Playlist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Playlist</em>'.
	 * @see videogenPlaylist.Playlist
	 * @generated
	 */
	EClass getPlaylist();

	/**
	 * Returns the meta object for the reference list '{@link videogenPlaylist.Playlist#getMediaFile <em>Media File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Media File</em>'.
	 * @see videogenPlaylist.Playlist#getMediaFile()
	 * @see #getPlaylist()
	 * @generated
	 */
	EReference getPlaylist_MediaFile();

	/**
	 * Returns the meta object for class '{@link videogenPlaylist.MediaFile <em>Media File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Media File</em>'.
	 * @see videogenPlaylist.MediaFile
	 * @generated
	 */
	EClass getMediaFile();

	/**
	 * Returns the meta object for the attribute '{@link videogenPlaylist.MediaFile#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see videogenPlaylist.MediaFile#getPath()
	 * @see #getMediaFile()
	 * @generated
	 */
	EAttribute getMediaFile_Path();

	/**
	 * Returns the meta object for the attribute '{@link videogenPlaylist.MediaFile#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see videogenPlaylist.MediaFile#getDuration()
	 * @see #getMediaFile()
	 * @generated
	 */
	EAttribute getMediaFile_Duration();

	/**
	 * Returns the meta object for the attribute '{@link videogenPlaylist.MediaFile#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see videogenPlaylist.MediaFile#getText()
	 * @see #getMediaFile()
	 * @generated
	 */
	EAttribute getMediaFile_Text();

	/**
	 * Returns the meta object for the attribute '{@link videogenPlaylist.MediaFile#getXAxis <em>XAxis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XAxis</em>'.
	 * @see videogenPlaylist.MediaFile#getXAxis()
	 * @see #getMediaFile()
	 * @generated
	 */
	EAttribute getMediaFile_XAxis();

	/**
	 * Returns the meta object for the attribute '{@link videogenPlaylist.MediaFile#getYAxis <em>YAxis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>YAxis</em>'.
	 * @see videogenPlaylist.MediaFile#getYAxis()
	 * @see #getMediaFile()
	 * @generated
	 */
	EAttribute getMediaFile_YAxis();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VideogenPlaylistFactory getVideogenPlaylistFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link videogenPlaylist.impl.PlaylistImpl <em>Playlist</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see videogenPlaylist.impl.PlaylistImpl
		 * @see videogenPlaylist.impl.VideogenPlaylistPackageImpl#getPlaylist()
		 * @generated
		 */
		EClass PLAYLIST = eINSTANCE.getPlaylist();

		/**
		 * The meta object literal for the '<em><b>Media File</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAYLIST__MEDIA_FILE = eINSTANCE.getPlaylist_MediaFile();

		/**
		 * The meta object literal for the '{@link videogenPlaylist.impl.MediaFileImpl <em>Media File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see videogenPlaylist.impl.MediaFileImpl
		 * @see videogenPlaylist.impl.VideogenPlaylistPackageImpl#getMediaFile()
		 * @generated
		 */
		EClass MEDIA_FILE = eINSTANCE.getMediaFile();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIA_FILE__PATH = eINSTANCE.getMediaFile_Path();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIA_FILE__DURATION = eINSTANCE.getMediaFile_Duration();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIA_FILE__TEXT = eINSTANCE.getMediaFile_Text();

		/**
		 * The meta object literal for the '<em><b>XAxis</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIA_FILE__XAXIS = eINSTANCE.getMediaFile_XAxis();

		/**
		 * The meta object literal for the '<em><b>YAxis</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIA_FILE__YAXIS = eINSTANCE.getMediaFile_YAxis();

	}

} //VideogenPlaylistPackage
