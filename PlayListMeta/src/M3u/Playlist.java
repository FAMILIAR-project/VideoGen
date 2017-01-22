/**
 */
package M3u;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Playlist</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link M3u.Playlist#getMediafile <em>Mediafile</em>}</li>
 * </ul>
 *
 * @see M3u.M3uPackage#getPlaylist()
 * @model
 * @generated
 */
public interface Playlist extends EObject {
	/**
	 * Returns the value of the '<em><b>Mediafile</b></em>' reference list.
	 * The list contents are of type {@link M3u.MediaFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mediafile</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mediafile</em>' reference list.
	 * @see M3u.M3uPackage#getPlaylist_Mediafile()
	 * @model
	 * @generated
	 */
	EList<MediaFile> getMediafile();

} // Playlist
