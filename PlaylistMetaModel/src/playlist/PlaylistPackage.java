/**
 */
package playlist;

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
 * @see playlist.PlaylistFactory
 * @model kind="package"
 * @generated
 */
public interface PlaylistPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "playlist";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/playlist";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "playlist";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PlaylistPackage eINSTANCE = playlist.impl.PlaylistPackageImpl.init();

	/**
	 * The meta object id for the '{@link playlist.impl.PlaylistImpl <em>Playlist</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see playlist.impl.PlaylistImpl
	 * @see playlist.impl.PlaylistPackageImpl#getPlaylist()
	 * @generated
	 */
	int PLAYLIST = 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYLIST__CONTENT = 0;

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
	 * The meta object id for the '{@link playlist.impl.EntryImpl <em>Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see playlist.impl.EntryImpl
	 * @see playlist.impl.PlaylistPackageImpl#getEntry()
	 * @generated
	 */
	int ENTRY = 1;

	/**
	 * The number of structural features of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link playlist.impl.CommentImpl <em>Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see playlist.impl.CommentImpl
	 * @see playlist.impl.PlaylistPackageImpl#getComment()
	 * @generated
	 */
	int COMMENT = 2;

	/**
	 * The number of structural features of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_FEATURE_COUNT = ENTRY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_OPERATION_COUNT = ENTRY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link playlist.impl.FileImpl <em>File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see playlist.impl.FileImpl
	 * @see playlist.impl.PlaylistPackageImpl#getFile()
	 * @generated
	 */
	int FILE = 3;

	/**
	 * The feature id for the '<em><b>Metadata</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__METADATA = ENTRY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__PATH = ENTRY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_FEATURE_COUNT = ENTRY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_OPERATION_COUNT = ENTRY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link playlist.impl.MetaDataImpl <em>Meta Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see playlist.impl.MetaDataImpl
	 * @see playlist.impl.PlaylistPackageImpl#getMetaData()
	 * @generated
	 */
	int META_DATA = 4;

	/**
	 * The feature id for the '<em><b>Duree</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA__DUREE = 0;

	/**
	 * The feature id for the '<em><b>Details</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA__DETAILS = 1;

	/**
	 * The number of structural features of the '<em>Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link playlist.Playlist <em>Playlist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Playlist</em>'.
	 * @see playlist.Playlist
	 * @generated
	 */
	EClass getPlaylist();

	/**
	 * Returns the meta object for the containment reference list '{@link playlist.Playlist#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Content</em>'.
	 * @see playlist.Playlist#getContent()
	 * @see #getPlaylist()
	 * @generated
	 */
	EReference getPlaylist_Content();

	/**
	 * Returns the meta object for class '{@link playlist.Entry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry</em>'.
	 * @see playlist.Entry
	 * @generated
	 */
	EClass getEntry();

	/**
	 * Returns the meta object for class '{@link playlist.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see playlist.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for class '{@link playlist.File <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File</em>'.
	 * @see playlist.File
	 * @generated
	 */
	EClass getFile();

	/**
	 * Returns the meta object for the containment reference '{@link playlist.File#getMetadata <em>Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Metadata</em>'.
	 * @see playlist.File#getMetadata()
	 * @see #getFile()
	 * @generated
	 */
	EReference getFile_Metadata();

	/**
	 * Returns the meta object for the attribute '{@link playlist.File#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see playlist.File#getPath()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_Path();

	/**
	 * Returns the meta object for class '{@link playlist.MetaData <em>Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Data</em>'.
	 * @see playlist.MetaData
	 * @generated
	 */
	EClass getMetaData();

	/**
	 * Returns the meta object for the attribute '{@link playlist.MetaData#getDuree <em>Duree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duree</em>'.
	 * @see playlist.MetaData#getDuree()
	 * @see #getMetaData()
	 * @generated
	 */
	EAttribute getMetaData_Duree();

	/**
	 * Returns the meta object for the attribute '{@link playlist.MetaData#getDetails <em>Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Details</em>'.
	 * @see playlist.MetaData#getDetails()
	 * @see #getMetaData()
	 * @generated
	 */
	EAttribute getMetaData_Details();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PlaylistFactory getPlaylistFactory();

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
		 * The meta object literal for the '{@link playlist.impl.PlaylistImpl <em>Playlist</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see playlist.impl.PlaylistImpl
		 * @see playlist.impl.PlaylistPackageImpl#getPlaylist()
		 * @generated
		 */
		EClass PLAYLIST = eINSTANCE.getPlaylist();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAYLIST__CONTENT = eINSTANCE.getPlaylist_Content();

		/**
		 * The meta object literal for the '{@link playlist.impl.EntryImpl <em>Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see playlist.impl.EntryImpl
		 * @see playlist.impl.PlaylistPackageImpl#getEntry()
		 * @generated
		 */
		EClass ENTRY = eINSTANCE.getEntry();

		/**
		 * The meta object literal for the '{@link playlist.impl.CommentImpl <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see playlist.impl.CommentImpl
		 * @see playlist.impl.PlaylistPackageImpl#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();

		/**
		 * The meta object literal for the '{@link playlist.impl.FileImpl <em>File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see playlist.impl.FileImpl
		 * @see playlist.impl.PlaylistPackageImpl#getFile()
		 * @generated
		 */
		EClass FILE = eINSTANCE.getFile();

		/**
		 * The meta object literal for the '<em><b>Metadata</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE__METADATA = eINSTANCE.getFile_Metadata();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__PATH = eINSTANCE.getFile_Path();

		/**
		 * The meta object literal for the '{@link playlist.impl.MetaDataImpl <em>Meta Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see playlist.impl.MetaDataImpl
		 * @see playlist.impl.PlaylistPackageImpl#getMetaData()
		 * @generated
		 */
		EClass META_DATA = eINSTANCE.getMetaData();

		/**
		 * The meta object literal for the '<em><b>Duree</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_DATA__DUREE = eINSTANCE.getMetaData_Duree();

		/**
		 * The meta object literal for the '<em><b>Details</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_DATA__DETAILS = eINSTANCE.getMetaData_Details();

	}

} //PlaylistPackage
