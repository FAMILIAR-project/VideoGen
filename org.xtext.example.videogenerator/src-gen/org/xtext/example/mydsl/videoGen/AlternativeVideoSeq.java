/**
 */
package org.xtext.example.mydsl.videoGen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternative Video Seq</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.videoGen.AlternativeVideoSeq#getVideoid <em>Videoid</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.videoGen.AlternativeVideoSeq#getVideodescs <em>Videodescs</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.videoGen.VideoGenPackage#getAlternativeVideoSeq()
 * @model
 * @generated
 */
public interface AlternativeVideoSeq extends VideoSeq
{
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
	 * @see org.xtext.example.mydsl.videoGen.VideoGenPackage#getAlternativeVideoSeq_Videoid()
	 * @model
	 * @generated
	 */
  String getVideoid();

  /**
	 * Sets the value of the '{@link org.xtext.example.mydsl.videoGen.AlternativeVideoSeq#getVideoid <em>Videoid</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Videoid</em>' attribute.
	 * @see #getVideoid()
	 * @generated
	 */
  void setVideoid(String value);

  /**
	 * Returns the value of the '<em><b>Videodescs</b></em>' containment reference list.
	 * The list contents are of type {@link org.xtext.example.mydsl.videoGen.VideoDescription}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Videodescs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Videodescs</em>' containment reference list.
	 * @see org.xtext.example.mydsl.videoGen.VideoGenPackage#getAlternativeVideoSeq_Videodescs()
	 * @model containment="true"
	 * @generated
	 */
  EList<VideoDescription> getVideodescs();

} // AlternativeVideoSeq
