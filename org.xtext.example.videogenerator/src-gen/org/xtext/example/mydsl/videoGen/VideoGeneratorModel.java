/**
 */
package org.xtext.example.mydsl.videoGen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Video Generator Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.videoGen.VideoGeneratorModel#getInformation <em>Information</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.videoGen.VideoGeneratorModel#getVideoseqs <em>Videoseqs</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.videoGen.VideoGenPackage#getVideoGeneratorModel()
 * @model
 * @generated
 */
public interface VideoGeneratorModel extends EObject
{
  /**
	 * Returns the value of the '<em><b>Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Information</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Information</em>' containment reference.
	 * @see #setInformation(VideoGenInformation)
	 * @see org.xtext.example.mydsl.videoGen.VideoGenPackage#getVideoGeneratorModel_Information()
	 * @model containment="true"
	 * @generated
	 */
  VideoGenInformation getInformation();

  /**
	 * Sets the value of the '{@link org.xtext.example.mydsl.videoGen.VideoGeneratorModel#getInformation <em>Information</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Information</em>' containment reference.
	 * @see #getInformation()
	 * @generated
	 */
  void setInformation(VideoGenInformation value);

  /**
	 * Returns the value of the '<em><b>Videoseqs</b></em>' containment reference list.
	 * The list contents are of type {@link org.xtext.example.mydsl.videoGen.VideoSeq}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Videoseqs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Videoseqs</em>' containment reference list.
	 * @see org.xtext.example.mydsl.videoGen.VideoGenPackage#getVideoGeneratorModel_Videoseqs()
	 * @model containment="true"
	 * @generated
	 */
  EList<VideoSeq> getVideoseqs();

} // VideoGeneratorModel
