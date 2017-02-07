/**
 */
package M3UPlaylist;

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
 *   <li>{@link M3UPlaylist.Playlist#getEntries <em>Entries</em>}</li>
 * </ul>
 *
 * @see M3UPlaylist.M3UPlaylistPackage#getPlaylist()
 * @model
 * @generated
 */
public interface Playlist extends EObject {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link M3UPlaylist.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see M3UPlaylist.M3UPlaylistPackage#getPlaylist_Entries()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Entry> getEntries();

} // Playlist
