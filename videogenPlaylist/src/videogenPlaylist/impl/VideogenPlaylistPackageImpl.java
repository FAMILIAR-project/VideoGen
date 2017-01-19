/**
 */
package videogenPlaylist.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import videogenPlaylist.MediaFile;
import videogenPlaylist.Playlist;
import videogenPlaylist.VideogenPlaylistFactory;
import videogenPlaylist.VideogenPlaylistPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VideogenPlaylistPackageImpl extends EPackageImpl implements VideogenPlaylistPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass playlistEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mediaFileEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see videogenPlaylist.VideogenPlaylistPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VideogenPlaylistPackageImpl() {
		super(eNS_URI, VideogenPlaylistFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link VideogenPlaylistPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VideogenPlaylistPackage init() {
		if (isInited) return (VideogenPlaylistPackage)EPackage.Registry.INSTANCE.getEPackage(VideogenPlaylistPackage.eNS_URI);

		// Obtain or create and register package
		VideogenPlaylistPackageImpl theVideogenPlaylistPackage = (VideogenPlaylistPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VideogenPlaylistPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VideogenPlaylistPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theVideogenPlaylistPackage.createPackageContents();

		// Initialize created meta-data
		theVideogenPlaylistPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVideogenPlaylistPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(VideogenPlaylistPackage.eNS_URI, theVideogenPlaylistPackage);
		return theVideogenPlaylistPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlaylist() {
		return playlistEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlaylist_MediaFile() {
		return (EReference)playlistEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMediaFile() {
		return mediaFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediaFile_Path() {
		return (EAttribute)mediaFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediaFile_Duration() {
		return (EAttribute)mediaFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediaFile_Text() {
		return (EAttribute)mediaFileEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediaFile_XAxis() {
		return (EAttribute)mediaFileEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediaFile_YAxis() {
		return (EAttribute)mediaFileEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VideogenPlaylistFactory getVideogenPlaylistFactory() {
		return (VideogenPlaylistFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		playlistEClass = createEClass(PLAYLIST);
		createEReference(playlistEClass, PLAYLIST__MEDIA_FILE);

		mediaFileEClass = createEClass(MEDIA_FILE);
		createEAttribute(mediaFileEClass, MEDIA_FILE__PATH);
		createEAttribute(mediaFileEClass, MEDIA_FILE__DURATION);
		createEAttribute(mediaFileEClass, MEDIA_FILE__TEXT);
		createEAttribute(mediaFileEClass, MEDIA_FILE__XAXIS);
		createEAttribute(mediaFileEClass, MEDIA_FILE__YAXIS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(playlistEClass, Playlist.class, "Playlist", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlaylist_MediaFile(), this.getMediaFile(), null, "MediaFile", null, 0, -1, Playlist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mediaFileEClass, MediaFile.class, "MediaFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMediaFile_Path(), ecorePackage.getEString(), "path", null, 0, 1, MediaFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMediaFile_Duration(), ecorePackage.getEDouble(), "duration", null, 0, 1, MediaFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMediaFile_Text(), ecorePackage.getEString(), "text", null, 0, 1, MediaFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMediaFile_XAxis(), ecorePackage.getEString(), "xAxis", null, 0, 1, MediaFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMediaFile_YAxis(), ecorePackage.getEString(), "yAxis", null, 0, 1, MediaFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //VideogenPlaylistPackageImpl
