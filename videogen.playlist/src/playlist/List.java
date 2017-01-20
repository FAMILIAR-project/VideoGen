/**
 */
package playlist;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link playlist.List#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @see playlist.PlaylistPackage#getList()
 * @model
 * @generated
 */
public interface List extends EObject {

	/**
	 * Returns the value of the '<em><b>Path</b></em>' containment reference list.
	 * The list contents are of type {@link playlist.FilePath}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' containment reference list.
	 * @see playlist.PlaylistPackage#getList_Path()
	 * @model containment="true"
	 * @generated
	 */
	EList<FilePath> getPath();

	String playlistFfmpeg();

	String playlistM3u();
} // List
