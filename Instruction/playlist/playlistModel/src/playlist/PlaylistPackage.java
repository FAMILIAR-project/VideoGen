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
	String eNS_URI = "http://www.xtext.org/example/mydsl/Playlist";

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
	 * The meta object id for the '{@link playlist.impl.PlaylistModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see playlist.impl.PlaylistModelImpl
	 * @see playlist.impl.PlaylistPackageImpl#getPlaylistModel()
	 * @generated
	 */
	int PLAYLIST_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Media</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYLIST_MODEL__MEDIA = 0;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYLIST_MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYLIST_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link playlist.impl.MediaImpl <em>Media</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see playlist.impl.MediaImpl
	 * @see playlist.impl.PlaylistPackageImpl#getMedia()
	 * @generated
	 */
	int MEDIA = 1;

	/**
	 * The number of structural features of the '<em>Media</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Media</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link playlist.impl.VideoMediaImpl <em>Video Media</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see playlist.impl.VideoMediaImpl
	 * @see playlist.impl.PlaylistPackageImpl#getVideoMedia()
	 * @generated
	 */
	int VIDEO_MEDIA = 2;

	/**
	 * The feature id for the '<em><b>Videoid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_MEDIA__VIDEOID = MEDIA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_MEDIA__LOCATION = MEDIA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_MEDIA__DURATION = MEDIA_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_MEDIA__NAME = MEDIA_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Video Media</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_MEDIA_FEATURE_COUNT = MEDIA_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Video Media</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_MEDIA_OPERATION_COUNT = MEDIA_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link playlist.PlaylistModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see playlist.PlaylistModel
	 * @generated
	 */
	EClass getPlaylistModel();

	/**
	 * Returns the meta object for the containment reference list '{@link playlist.PlaylistModel#getMedia <em>Media</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Media</em>'.
	 * @see playlist.PlaylistModel#getMedia()
	 * @see #getPlaylistModel()
	 * @generated
	 */
	EReference getPlaylistModel_Media();

	/**
	 * Returns the meta object for class '{@link playlist.Media <em>Media</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Media</em>'.
	 * @see playlist.Media
	 * @generated
	 */
	EClass getMedia();

	/**
	 * Returns the meta object for class '{@link playlist.VideoMedia <em>Video Media</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Video Media</em>'.
	 * @see playlist.VideoMedia
	 * @generated
	 */
	EClass getVideoMedia();

	/**
	 * Returns the meta object for the attribute '{@link playlist.VideoMedia#getVideoid <em>Videoid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Videoid</em>'.
	 * @see playlist.VideoMedia#getVideoid()
	 * @see #getVideoMedia()
	 * @generated
	 */
	EAttribute getVideoMedia_Videoid();

	/**
	 * Returns the meta object for the attribute '{@link playlist.VideoMedia#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see playlist.VideoMedia#getLocation()
	 * @see #getVideoMedia()
	 * @generated
	 */
	EAttribute getVideoMedia_Location();

	/**
	 * Returns the meta object for the attribute '{@link playlist.VideoMedia#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see playlist.VideoMedia#getDuration()
	 * @see #getVideoMedia()
	 * @generated
	 */
	EAttribute getVideoMedia_Duration();

	/**
	 * Returns the meta object for the attribute '{@link playlist.VideoMedia#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see playlist.VideoMedia#getName()
	 * @see #getVideoMedia()
	 * @generated
	 */
	EAttribute getVideoMedia_Name();

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
		 * The meta object literal for the '{@link playlist.impl.PlaylistModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see playlist.impl.PlaylistModelImpl
		 * @see playlist.impl.PlaylistPackageImpl#getPlaylistModel()
		 * @generated
		 */
		EClass PLAYLIST_MODEL = eINSTANCE.getPlaylistModel();

		/**
		 * The meta object literal for the '<em><b>Media</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAYLIST_MODEL__MEDIA = eINSTANCE.getPlaylistModel_Media();

		/**
		 * The meta object literal for the '{@link playlist.impl.MediaImpl <em>Media</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see playlist.impl.MediaImpl
		 * @see playlist.impl.PlaylistPackageImpl#getMedia()
		 * @generated
		 */
		EClass MEDIA = eINSTANCE.getMedia();

		/**
		 * The meta object literal for the '{@link playlist.impl.VideoMediaImpl <em>Video Media</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see playlist.impl.VideoMediaImpl
		 * @see playlist.impl.PlaylistPackageImpl#getVideoMedia()
		 * @generated
		 */
		EClass VIDEO_MEDIA = eINSTANCE.getVideoMedia();

		/**
		 * The meta object literal for the '<em><b>Videoid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_MEDIA__VIDEOID = eINSTANCE.getVideoMedia_Videoid();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_MEDIA__LOCATION = eINSTANCE.getVideoMedia_Location();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_MEDIA__DURATION = eINSTANCE.getVideoMedia_Duration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIDEO_MEDIA__NAME = eINSTANCE.getVideoMedia_Name();

	}

} //PlaylistPackage
