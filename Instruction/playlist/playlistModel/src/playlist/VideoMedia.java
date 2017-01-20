/**
 */
package playlist;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Video Media</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link playlist.VideoMedia#getVideoid <em>Videoid</em>}</li>
 *   <li>{@link playlist.VideoMedia#getLocation <em>Location</em>}</li>
 *   <li>{@link playlist.VideoMedia#getDuration <em>Duration</em>}</li>
 *   <li>{@link playlist.VideoMedia#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see playlist.PlaylistPackage#getVideoMedia()
 * @model
 * @generated
 */
public interface VideoMedia extends Media {
	/**
	 * Returns the value of the '<em><b>Videoid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Videoid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Videoid</em>' attribute.
	 * @see #setVideoid(String)
	 * @see playlist.PlaylistPackage#getVideoMedia_Videoid()
	 * @model
	 * @generated
	 */
	String getVideoid();

	/**
	 * Sets the value of the '{@link playlist.VideoMedia#getVideoid <em>Videoid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Videoid</em>' attribute.
	 * @see #getVideoid()
	 * @generated
	 */
	void setVideoid(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see playlist.PlaylistPackage#getVideoMedia_Location()
	 * @model
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link playlist.VideoMedia#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(int)
	 * @see playlist.PlaylistPackage#getVideoMedia_Duration()
	 * @model
	 * @generated
	 */
	int getDuration();

	/**
	 * Sets the value of the '{@link playlist.VideoMedia#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see playlist.PlaylistPackage#getVideoMedia_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link playlist.VideoMedia#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // VideoMedia
