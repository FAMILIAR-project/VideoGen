/**
 */
package playlist;

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
 *   <li>{@link playlist.Playlist#getMedia <em>Media</em>}</li>
 * </ul>
 *
 * @see playlist.PlaylistPackage#getPlaylist()
 * @model
 * @generated
 */
public interface Playlist extends EObject {
	/**
	 * Returns the value of the '<em><b>Media</b></em>' reference list.
	 * The list contents are of type {@link playlist.Media}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Media</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Media</em>' reference list.
	 * @see playlist.PlaylistPackage#getPlaylist_Media()
	 * @model
	 * @generated
	 */
	EList<Media> getMedia();

} // Playlist
